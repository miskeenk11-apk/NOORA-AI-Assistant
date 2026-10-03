package com.noora.assistant
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
class MainActivity: ComponentActivity(){
 override fun onCreate(b:Bundle?){super.onCreate(b);setContentView(R.layout.activity_main); if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED) ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.RECORD_AUDIO),100) else startService()}
 override fun onRequestPermissionsResult(r:Int,p:Array<out String>,g:IntArray){super.onRequestPermissionsResult(r,p,g);if(r==100&&g.isNotEmpty()&&g[0]==PackageManager.PERMISSION_GRANTED)startService() else Toast.makeText(this,"Microphone permission is required for JARVIS.",Toast.LENGTH_LONG).show()}
 private fun startService(){ContextCompat.startForegroundService(this,Intent(this,WakeWordService::class.java))}
}
