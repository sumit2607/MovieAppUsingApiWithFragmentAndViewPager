package com.example.movieappusingapiwithfragmentandviewpager;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;


public class ResponseDTO implements Serializable {

	@SerializedName("coming_soon")
	private List<ComingSoonDTO> comingSoon;

	@SerializedName("now_showing")
	private List<NowShowingDTO> nowShowing;

	public void setComingSoon(List<ComingSoonDTO> comingSoon){
		this.comingSoon = comingSoon;
	}

	public List<ComingSoonDTO> getComingSoon(){
		return comingSoon;
	}

	public void setNowShowing(List<NowShowingDTO> nowShowing){
		this.nowShowing = nowShowing;
	}

	public List<NowShowingDTO> getNowShowing(){
		return nowShowing;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"coming_soon = '" + comingSoon + '\'' + 
			",now_showing = '" + nowShowing + '\'' + 
			"}";
		}
}