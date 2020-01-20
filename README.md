<h3>Use Google Map in Android Project</h3>
<ul>
<li>
In buile.gardle (Project)
<ol>
<li>add the following responsability to the responsabilites list
<pre>
        maven(){
            url 'https://maven.google.com/'
            name 'Google'
        }
        </pre>
        </li>
        <li>add the following to the dependencies
                <code>classpath 'com.android.support:appcompat-v7:+'</code>
</li>
</ol>
</li>
                <br>

<li> In build.garlde (Module) add the following to the dependencies
<pre>
implementation 'com.google.android.gms:play-services-maps:17.0.0'
implementation 'com.google.android.gms:play-services-maps:+'

</pre>
</li>
        <br>

<li>Go to google map platform, create a project and get a api_key
<br>
then add the following to Manifist
<pre>
      ( meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="your .API_KEY" /)
       ( meta-data
            android:name="com.google.android.gms.version"
            android:value="@integer/google_play_services_version" /)
</pre>
</li>
        <br>

<li>Put map fragment in the xml file  as the following

<pre>
(fragment
            android:id="@+id/map"
            android:name="com.google.android.gms.maps.SupportMapFragment"
            android:layout_width="300dp"
            android:layout_height="400dp"
            tools:context=".MapsActivity" /)
</pre>
<mar>Note: Don't forget to use proper constraits</mark></li>
        <br>

<li>
Now you can use the map in your activity
<pre>
 SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mgoogleMap) {
              GoogleMap  googleMap = mgoogleMap;
              //define thae latitude and logitude of the desired place
                LatLng place1 = new LatLng(41.890190, 12.492150);
                //define the zoom on the place
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(44.4, 12.4), 5));
                //creates a marker on the map
                googleMap.addMarker(new MarkerOptions().position(place1));
            }
        });
        </pre>
</li>
</ul>
