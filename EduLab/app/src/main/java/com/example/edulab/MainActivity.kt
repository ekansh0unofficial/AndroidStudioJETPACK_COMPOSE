package com.example.edulab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edulab.data.SubjectList
import com.example.edulab.model.SubjectDetails
import com.example.edulab.ui.theme.EduLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EduLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EduApp()
                }
            }
        }
    }
}

@Composable
fun EduApp(modifier: Modifier = Modifier){
    CourseGrid(SubjectList.loadSubjectList())
}
@Composable
fun SubjectPlate(subject : SubjectDetails , modifier: Modifier = Modifier){
    Surface(modifier.wrapContentSize() , shape = RoundedCornerShape(8.dp)) {
            Row(modifier.background(Color(0, 137, 123, 255))) {
                Image(
                    painter = painterResource(subject.imageResourceId),
                    contentDescription = subject.subjectResourceId.toString(),
                    modifier = Modifier.size(82.dp)
                )
                Column(modifier = modifier.padding(16.dp,16.dp,16.dp,0.dp)) {
                    Text(
                        stringResource(subject.subjectResourceId) ,
                        fontFamily = FontFamily.Serif,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Justify,
                        color = Color.White

                    )
                    Spacer(modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription ="Icon",
                        )
                        Spacer(modifier.width(8.dp))
                        Text(
                            subject.courseNumber.toString(),
                            fontSize = 14.sp,
                            color = Color.White

                        )
                    }
                }
            }
    }
}

@Composable
fun CourseGrid(courseList : List<SubjectDetails> ,modifier: Modifier = Modifier) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(courseList) {
                    course ->
                    SubjectPlate(subject = course)
                }
            }
            )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EduLabTheme {
       EduApp()
    }
}