package com.example.loginapplication;


import android.os.Parcel;
import android.os.Parcelable;
public class FakeServer implements Parcelable {

    private String name;
    private String password;

    public FakeServer() {

    }

    FakeServer(Parcel in) {
        name = in.readString();
        password = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FakeServer> CREATOR = new Creator<FakeServer>() {
        @Override
        public FakeServer createFromParcel(Parcel in) {
            return new FakeServer(in);
        }

        @Override
        public FakeServer[] newArray(int size) {
            return new FakeServer[size];
        }
    };

    void registeruser(String name, String password){
    this.name = name;
    this.password = password;
}
public boolean isExistingUser(String username,String userpassword)
{
    return username.equals(name)&& password.equals(userpassword);
}


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(password);
    }
}
