package com.xsoftcdmx.list_detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xsoft.pokemonexam.core.model.ResultUiModel
import com.xsoftcdmx.designsystem.PokemonIcons.ic_favorite
import com.xsoftcdmx.designsystem.PokemonIcons.ic_favorite_fill
import com.xsoftcdmx.designsystem.components.CircularImage
import com.xsoftcdmx.designsystem.components.rememberDominantColorFromImage
import com.xsoftcdmx.designsystem.R

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    pokemonItem: ResultUiModel,
    onFavoriteClick: (ResultUiModel) -> Unit,
    onPokemonClick: () -> Unit
) {
    val backgroundColor = rememberDominantColorFromImage(pokemonItem.pathSprite())
    Row(
        modifier = modifier
            .fillMaxWidth().clickable {
                onPokemonClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.weight(1f)
        ) {
            CircularImage(
                imageUrl = pokemonItem.pathSprite(),
                text = pokemonItem.name,
                placeholder = {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(Color.Gray, shape = CircleShape)
                    )
                },
                textColor = Color.White,
                modifier = Modifier
                    .size(64.dp)
                    .background(backgroundColor, CircleShape)
            )

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = pokemonItem.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase() else it.toString()
                },
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
        }

        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = {
                onFavoriteClick(pokemonItem)
            }
        ) {
            val icon = if (pokemonItem.isFavorite) ic_favorite_fill else ic_favorite
            val description = if (pokemonItem.isFavorite) {
                stringResource(id = R.string.favorite_description)
            } else {
                stringResource(id = R.string.favorite_description)
            }
            Icon(
                imageVector = icon,
                tint = MaterialTheme.colorScheme.error,
                contentDescription = description
            )
        }
    }

}


