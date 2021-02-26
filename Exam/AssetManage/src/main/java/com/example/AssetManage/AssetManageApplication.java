package com.example.AssetManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.example.AssetManage.*")
public class AssetManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManageApplication.class, args);
	}

}
