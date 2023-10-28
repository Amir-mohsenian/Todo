package com.photo.mahsa.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.theme.MahsaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImmutableTaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onClick: (Task) -> Unit
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 12.dp,
            hoveredElevation = 8.dp
        ),
        content = {
            Text(
                text = task.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 4.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            Text(
                text = task.desc, modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        },
        onClick = { onClick(task) }
    )
}

@Preview
@Composable
fun ImmutableTaskCardPreview() {
    MahsaTheme {
        ImmutableTaskCard(
            task = Task(
                1,
                "title",
                "desc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls dfdesc fsdfsdjlfk lsdkfj hklsdj fkls df"
            ), onClick = {})
    }
}