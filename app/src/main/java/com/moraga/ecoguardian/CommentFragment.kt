package com.moraga.ecoguardian

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.moraga.ecoguardian.databinding.FragmentCommentBinding

class CommentFragment : Fragment() {

    private lateinit var binding: FragmentCommentBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentBinding.inflate(inflater, container, false)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        binding.btnSelectMedia.setOnClickListener {
            val pickPhotoIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickPhotoIntent.type = "image/*"
            startActivityForResult(pickPhotoIntent, REQUEST_PICK_IMAGE)
        }

        binding.btnLocation.setOnClickListener {
            getLocation()
        }

        binding.btnPost.setOnClickListener {
            val comment = binding.etComment.text.toString()

            // Lógica para subir imagen, comentario y ubicación
            Toast.makeText(requireContext(), "Publicación creada", Toast.LENGTH_SHORT).show()

            // Clear the input fields and reset the image preview
            binding.etComment.text?.clear()
            binding.tvLocation.text = "Ubicación: "
            binding.ivPreview.setImageURI(null) // Clear the image preview
        }

        return binding.root
    }

    private fun getLocation() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    binding.tvLocation.text = "Ubicación: ${it.latitude}, ${it.longitude}"
                }
            }
        } else {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            val selectedImage = data?.data
            binding.ivPreview.setImageURI(selectedImage)
        }
    }

    companion object {
        private const val REQUEST_PICK_IMAGE = 101
        private const val LOCATION_PERMISSION_REQUEST_CODE = 102
    }
}
