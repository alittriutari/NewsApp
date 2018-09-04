package com.example.ramapradana67.newsapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticlesItem implements Parcelable {
	private String publishedAt;
	private String author;
	private String urlToImage;
	private String description;
	private Source source;
	private String title;
	private String url;

	public void setPublishedAt(String publishedAt){
		this.publishedAt = publishedAt;
	}

	public String getPublishedAt(){
		return publishedAt;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setUrlToImage(String urlToImage){
		this.urlToImage = urlToImage;
	}

	public String getUrlToImage(){
		return urlToImage;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"ArticlesItem{" + 
			"publishedAt = '" + publishedAt + '\'' + 
			",author = '" + author + '\'' + 
			",urlToImage = '" + urlToImage + '\'' + 
			",description = '" + description + '\'' + 
			",source = '" + source + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.publishedAt);
		dest.writeString(this.author);
		dest.writeString(this.urlToImage);
		dest.writeString(this.description);
		dest.writeString(this.title);
		dest.writeString(this.url);
	}

	public ArticlesItem() {
	}

	protected ArticlesItem(Parcel in) {
		this.publishedAt = in.readString();
		this.author = in.readString();
		this.urlToImage = in.readString();
		this.description = in.readString();
		this.title = in.readString();
		this.url = in.readString();
	}

	public static final Parcelable.Creator<ArticlesItem> CREATOR = new Parcelable.Creator<ArticlesItem>() {
		@Override
		public ArticlesItem createFromParcel(Parcel source) {
			return new ArticlesItem(source);
		}

		@Override
		public ArticlesItem[] newArray(int size) {
			return new ArticlesItem[size];
		}
	};
}
