package vn.edu.vlsc.kiemtra_mobileapp_2500116169
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ thành phần giao diện bằng findViewById (Bắt buộc theo yêu cầu đề bài)
        val tvEmailProfile = findViewById<TextView>(R.id.tvEmailProfile)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận chuỗi Email được truyền sang qua Intent từ MainActivity[cite: 9]
        val email = intent.getStringExtra("USER_EMAIL")
        tvEmailProfile.text = "Email: $email"

        // Xử lý nút Đăng xuất: dùng finish() đóng Activity hiện tại để quay về màn hình Login[cite: 9]
        btnLogout.setOnClickListener {
            finish()
        }
    }
}