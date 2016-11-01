package com.blg.rtu.aidl ;


import android.os.Parcel;
import android.os.Parcelable;

public class RemoteParcel implements Parcelable {
	
	public RemoteData packet;
	
	public static final Parcelable.Creator<RemoteParcel> CREATOR = new Parcelable.Creator<RemoteParcel>() {
		
		public RemoteParcel createFromParcel(Parcel in) {
			return new RemoteParcel(in);
		}
		
		public RemoteParcel[] newArray(int size) {
			return new RemoteParcel[size];
		}
	};

	public RemoteParcel(RemoteData packet) {
		this.packet = packet ;
	}
	
	private RemoteParcel(Parcel in) {
		packet = (RemoteData)in.readValue(RemoteData.class.getClassLoader()) ;
	}


	@Override
	public int describeContents() {
		return 0;
	}


	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeValue(packet);
	}

}
