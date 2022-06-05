package ru.kheynov.feature_stories

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage
import ru.kheynov.feature_stories.stories_progress.StoriesProgressBar
import ru.kheynov.feature_stories.theme.StoriesScreenTheme

private const val TAG = "StoriesScreen"

@Composable
fun StoriesScreen(
    viewModel: StoriesScreenViewModel = viewModel(),
) {
    val storiesProgress by viewModel.storiesProgress.observeAsState()
    val context = LocalContext.current
    StoriesScreenTheme {

        Surface(modifier = Modifier.fillMaxSize(), color =
        MaterialTheme.colors
            .background) {
            GlideImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .blur(200.dp),
                imageModel = (viewModel.items[storiesProgress ?: 0])
                    .image,
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.surface,
                    highlightColor = MaterialTheme.colors.background,
                    durationMillis = 500,
                    dropOff = 0.65f,
                    tilt = 20f,
                ),
                requestOptions = {
                    RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .centerCrop()
                },
                contentScale = ContentScale.FillHeight,
            )
            Box(
                modifier = Modifier
                    .background(brush = Brush.verticalGradient(colors = listOf(
                        Color(0f, 0f, 0f, 0.75f), Color(0f, 0f, 0f, 0.75f)), startY = 500f))
                    .fillMaxSize(1f),//TODO: Draw mor // e beautiful shadow
            )
            Column(Modifier.fillMaxSize()) {
                Log.i(TAG, "RECOMPOSITION")
                Spacer(modifier = Modifier.height(20.dp))
                StoriesProgressBar(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp),
                    state = (storiesProgress ?: 0) + 1)
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "${viewModel.items[storiesProgress ?: 0].city} ",
                                style = MaterialTheme.typography.h2,
                                color = Color.White,
                                fontSize = 36.sp,
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                            Text(
                                text = viewModel.items[storiesProgress ?: 0].date,
                                style = MaterialTheme.typography.body1,
                                color = Color.White,
                                fontSize = 16.sp,
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                        }

                        Box {

                            GlideImage(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(10.dp)),
                                imageModel = (viewModel.items[storiesProgress ?: 0])
                                    .image,
                                shimmerParams = ShimmerParams(
                                    baseColor = MaterialTheme.colors.surface,
                                    highlightColor = MaterialTheme.colors.background,
                                    durationMillis = 500,
                                    dropOff = 0.65f,
                                    tilt = 20f,
                                ),
                                requestOptions = {
                                    RequestOptions()
                                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                                        .centerCrop()
                                },
                                contentScale = ContentScale.Fit,
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp, vertical = 85.dp),
                                verticalArrangement = Arrangement.Bottom,
                            ) {
                                Text(
                                    text = "${viewModel.items[storiesProgress ?: 0].header} ",
                                    style = MaterialTheme.typography.h2,
                                    color = Color.White,
                                    fontSize = 36.sp,
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = viewModel.items[storiesProgress ?: 0].description,
                                    style = MaterialTheme.typography.body1,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                )
                            }
                            Row(Modifier.fillMaxSize()) {
                                Box(modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.5f)
                                    .clickable(interactionSource = remember {
                                        MutableInteractionSource()
                                    },
                                        indication
                                        = null) {
                                        viewModel.decrementProgress()
                                        Log.i(TAG,
                                            "Progress: ${(storiesProgress ?: 0)}")
                                    }
                                )
                                Box(modifier = Modifier
                                    .fillMaxSize()
                                    .clickable(interactionSource = remember {
                                        MutableInteractionSource()
                                    },
                                        indication
                                        = null) {
                                        viewModel.incrementProgress()
                                        Log.i(TAG,
                                            "Progress: ${(storiesProgress ?: 0)}")
                                    }
                                )
                            }

                            Box(modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 24.dp),
                                contentAlignment = Alignment.BottomCenter) {

                                Image(imageVector = ImageVector.vectorResource(
                                    id = R.drawable.ic_button_details),
                                    contentDescription = "",
                                    modifier = Modifier.clickable {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel
                                            .items[storiesProgress ?: 0].link))
                                        startActivity(context,
                                            intent, null)
                                    }
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}