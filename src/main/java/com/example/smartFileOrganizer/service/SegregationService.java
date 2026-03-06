package com.example.smartFileOrganizer.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class SegregationService {

    public void segregate(String scanPath,
                          Map<String,String> destMap,
                          List<String> allowedPaths){

        File folder=new File(scanPath);

        File[] files=folder.listFiles();

        if(files==null) return;

        for(File file:files){

            if(file.isFile()){

                String name=file.getName();

                int dot=name.lastIndexOf(".");

                String ext="";

                if(dot>0){
                    ext=name.substring(dot+1);
                }

                if(destMap.containsKey(ext)){

                    String destPath=destMap.get(ext);

                    if(destPath==null || destPath.isEmpty())
                        continue;

                    boolean allowed=false;

                    for(String path:allowedPaths){

                        if(destPath.startsWith(path)){
                            allowed=true;
                            break;
                        }
                    }

                    if(!allowed){
                        throw new RuntimeException(
                                "Destination path not allowed");
                    }

                    File destFolder=new File(destPath);

                    destFolder.mkdirs();

                    file.renameTo(new File(destFolder,name));
                }
            }
        }
    }
}