package com.nextep.s3.util;

import java.io.IOException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

public class S3Util {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("AWS_ACCESS_KEY_ID", "AKIAQYDD5HW6W3ASPKON");
		System.setProperty("AWS_SECRET_ACCESS_KEY", "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");
		
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
		
		//Create a bucket
		//s3.createBucket("nextep-training-bucket-through-java");
		
		//Get a specific object contents in a bucket
		GetObjectRequest getObjectRequest = new GetObjectRequest("nextep-training-weather-data", "weather-data.csv");
		S3Object s3Object = s3.getObject(getObjectRequest);
		S3ObjectInputStream s3ObjIs = s3Object.getObjectContent();
		String content = IOUtils.toString(s3ObjIs);
		System.out.println(content);

		//Upload an object with content in a bucket
		s3.putObject("nextep-training-weather-data", "zipCodeData.txt", "test:48073, test2:65432");
	}
}
