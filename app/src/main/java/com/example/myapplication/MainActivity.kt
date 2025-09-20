package com.example.myapplication

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                )
                {
                    Box(contentAlignment = Alignment.Center)
                    {
                        Card(
                            elevation = CardDefaults.cardElevation(8.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.padding(16.dp)
                        )
                        {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)

                            ) {
                                GraphicalInfo(name = "Guilherme Simão", type =  "Sound Engineer", modifier = Modifier)
                                PersonalInfoText("999000111","guilherme.lab01@gmail.com", "guilherme.simao", "gfgbsimao")

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GraphicalInfo(name : String, type: String, modifier: Modifier = Modifier){


        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp) // tamanho da foto
                    .clip(CircleShape) // torna-a circular
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 40.sp)
            )

            Text(
                text = type,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 30.sp),
            )
        }
}


@Composable
fun PersonalInfoText(phonenumber: String, email: String, linkedin: String , github: String,  modifier: Modifier = Modifier){

    Column (verticalArrangement = Arrangement.Center, modifier = modifier.padding(vertical = 20.dp)) {
        Text(
            text = "Telemóvel: $phonenumber",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Email: $email",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Linkedin: $linkedin",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Github: $github",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun PersonalBusinessCardPreview() {
    MyApplicationTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        )
        {
            Box(contentAlignment = Alignment.Center)
            {
                Card(
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 30.dp)
                    )
                {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)

                    ) {
                        GraphicalInfo(name = "Guilherme Simão", type =  "Sound Engineer", modifier = Modifier)
                        Spacer(modifier = Modifier.height(15.dp))
                        PersonalInfoText("999000111","guilherme.lab01@gmail.com", "guilherme.simao", "gfgbsimao")

                    }
                }
            }
        }
    }
}