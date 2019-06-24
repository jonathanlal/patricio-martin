package com.patriciomartin.models;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Storage.BlobTargetOption;
import java.io.UnsupportedEncodingException;

public class GoogleStorage {
	

//	  public GoogleStorage(Storage storage) {
//	    this.storage = storage;
//	  }
	private static Storage getStorage() {
		StorageOptions.Builder optionsBuilder = StorageOptions.newBuilder();
	    return optionsBuilder.build().getService();
	}
	
	  /** Example of creating a bucket. */
	  public Bucket createBucket(String bucketName) {
	    Bucket bucket = getStorage().create(BucketInfo.of(bucketName));
	    return bucket;
	  }
	  /** Example of reading all bytes of a blob. */
	  public byte[] readBlob(String bucketName, String blobName) {
	    return getStorage().readAllBytes(bucketName, blobName);
	  }
	
	  /** Example of uploading a text blob. */
	  public Blob createTextBlob(String bucketName, String blobName, String text) throws UnsupportedEncodingException {
	    byte[] data = text.getBytes(UTF_8);
	    BlobId blobId = BlobId.of(bucketName, blobName);
	    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
	    Blob blob = getStorage().create(blobInfo, data);
	    return blob;
	  }
	  public void createTextBlobListOfBlobsInBucket(String bucketName) throws UnsupportedEncodingException {
		  Bucket bucket = getStorage().create(BucketInfo.of(bucketName));
		  String text = "";
		  String nl = " \n";
		    Page<Blob> blobs = bucket.list();
		    for (Blob blob : blobs.iterateAll()) {
		      text += blob.getName()+nl;
		    }
		    createTextBlob(bucketName, "blobsInBucket-"+bucketName+".txt", text);
		  }
	 
	  
	  


}
