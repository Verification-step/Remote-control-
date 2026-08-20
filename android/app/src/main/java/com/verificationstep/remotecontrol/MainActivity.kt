package com.verificationstep.remotecontrol

import android.app.Activity
import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val screenCaptureRequest = 7001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 72, 48, 48)
            gravity = Gravity.CENTER_HORIZONTAL
        }

        val title = TextView(this).apply {
            text = "Remote Control"
            textSize = 28f
        }

        val status = TextView(this).apply {
            text = "\nReady\n\nThe remote session is off. Start screen sharing only when you want your laptop to view this phone."
            textSize = 16f
        }

        val screenButton = Button(this).apply {
            text = "Allow Screen Sharing"
            setOnClickListener { requestScreenCapture() }
        }

        val accessibilityButton = Button(this).apply {
            text = "Enable Remote Touch"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }

        val disconnectButton = Button(this).apply {
            text = "Disconnect"
            isEnabled = false
        }

        root.addView(title)
        root.addView(status)
        root.addView(screenButton)
        root.addView(accessibilityButton)
        root.addView(disconnectButton)
        setContentView(root)
    }

    private fun requestScreenCapture() {
        val manager = getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        startActivityForResult(manager.createScreenCaptureIntent(), screenCaptureRequest)
    }
}
