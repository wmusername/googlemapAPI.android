package com.example.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //원하는 위치에 위치가 뜨도록 설정
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
       //지도 객체 얻어옴
        mapFragment.getMapAsync((OnMapReadyCallback) this);
    }

    //callback에 의해서 지도객체 얻어옴
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        //특정 위치로 옮기기위한 객체 위도와 경도
        // 37.557667, 126.926546 홍대입구역

        //위도경도를 기반으로 위치정보를 갖는 클래스
        LatLng latlng = new LatLng(37.557667, 126.926546);
        //카메라가 바라보는 위치를 좌표를 만드는 객체
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        //지도를 확대
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        //홍대입구역 위에 마커 추가
        MarkerOptions markerOptions = new MarkerOptions().position(latlng).title("홍대입구역");
        googleMap.addMarker(markerOptions);


    }
}