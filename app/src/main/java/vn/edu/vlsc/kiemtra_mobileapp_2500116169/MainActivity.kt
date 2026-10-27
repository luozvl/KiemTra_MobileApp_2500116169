package vn.edu.vlsc.kiemtra_mobileapp_2500116169

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.getText().toString().trim()
            val password = edtPassword.getText().toString().trim()

            // 1. Kiểm tra bỏ trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Lỗi: Vui lòng không để trống Email hoặc Mật khẩu!"
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email chuẩn xác (phải có '@', có dấu '.', và '@' đứng trước '.')
            val isValidEmail = email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".")
            if (!isValidEmail) {
                tvStatus.text = "Lỗi: Định dạng Email không hợp lệ!"
                return@setOnClickListener
            }

            // 3. Kiểm tra Mật khẩu >= 6 ký tự
            if (password.length < 6) {
                tvStatus.text = "Lỗi: Mật khẩu phải có từ 6 ký tự trở lên!"
                return@setOnClickListener
            }

            // 4. Dữ liệu hợp lệ hoàn toàn
            tvStatus.text = "Đăng nhập hợp lệ"
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }
        }
    }