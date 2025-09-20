package com.example.tp1cm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp1cm.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonalBusinessCard(
                        name = "Guilherme Simão",
                        title = "Sound Engineer",
                        phone = "999000111",
                        email = "guilherme.lab01@gmail.com",
                        linkedin = "guilherme.simao",
                        github = "gfgbsimao"
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalBusinessCard(
    name: String,
    title: String,
    phone: String,
    email: String,
    linkedin: String,
    github: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f) // ocupa quase a largura total
                .fillMaxHeight(0.9f) // ocupa parte da altura (não fica gigante)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                            .border(4.dp, Color.White, CircleShape)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = name,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    InfoRow("📞", phone)
                    InfoRow("✉️", email)
                    InfoRow("in", linkedin)
                    InfoRow("GH", github)
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PersonalBusinessCardPreview() {
    MyApplicationTheme {
        PersonalBusinessCard(
            name = "Guilherme Simão",
            title = "Sound Engineer",
            phone = "999000111",
            email = "guilherme.lab01@gmail.com",
            linkedin = "guilherme.simao",
            github = "gfgbsimao"
        )
    }
}
