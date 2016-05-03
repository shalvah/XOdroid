package com.shalvahadebayo.xodroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
	{

		final ImageButton[][] tileImage = new ImageButton[3][3];
		final Board board = new Board();
		int playCount;
		boolean gameOver = false;
		TextView infoTV;
		TextView winnerTV;

		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			infoTV = (TextView) findViewById(R.id.info);
			winnerTV = (TextView) findViewById(R.id.winner);


			tileImage[0][0] = (ImageButton) findViewById(R.id.tile_img_00);
			tileImage[0][1] = (ImageButton) findViewById(R.id.tile_img_01);
			tileImage[0][2] = (ImageButton) findViewById(R.id.tile_img_02);
			tileImage[1][0] = (ImageButton) findViewById(R.id.tile_img_10);
			tileImage[1][1] = (ImageButton) findViewById(R.id.tile_img_11);
			tileImage[1][2] = (ImageButton) findViewById(R.id.tile_img_12);
			tileImage[2][0] = (ImageButton) findViewById(R.id.tile_img_20);
			tileImage[2][1] = (ImageButton) findViewById(R.id.tile_img_21);
			tileImage[2][2] = (ImageButton) findViewById(R.id.tile_img_22);

			for (int i = 0; i < 3; i++)
			{
				final int finalI = i;

				for (int j = 0; j < 3; j++)
				{
					final int finalJ = j;
					tileImage[i][j].setOnClickListener(new View.OnClickListener()
					{
						@Override
						public void onClick(View v)
						{
							if (!gameOver)
							{

								if (board.played[finalI][finalJ])
								{
									infoTV.setText(R.string.played_already);
									infoTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
									return;
								}
								playCount++;
								if (playCount == 9)
									board.full = true;
								char val = ((playCount % 2) == 0) ? 'O' : 'X';
								if (val == 'X')
								{
									tileImage[finalI][finalJ].setImageResource(R.drawable.xdroid);
									infoTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28);
									infoTV.setText(R.string.oturn);
									infoTV.setTextColor(getResources().getColor(R.color.colorO));
								} else
								{
									tileImage[finalI][finalJ].setImageResource(R.drawable.odroid);
									infoTV.setText(R.string.xturn);
									infoTV.setTextColor(getResources().getColor(R.color.colorX));
								}

								board.play(finalI, finalJ, val);

								if (playCount >= 5)
								{
									if (board.isWon())
									{
										gameOver = true;
										infoTV.setText(R.string.over);
										infoTV.setTextColor(getResources().getColor(android.R.color.black));
										winnerTV.setText(board.winner + getString(R.string.win));
										if (board.winner == 'X')
										{
											winnerTV.setTextColor(getResources().getColor(R.color.colorX));
										} else
										{
											winnerTV.setTextColor(getResources().getColor(R.color.colorO));
										}
										winnerTV.setVisibility(View.VISIBLE);
									} else if (board.full)
									{
										gameOver = true;
										infoTV.setText(R.string.over);
										winnerTV.setText(R.string.draw);
										winnerTV.setVisibility(View.VISIBLE);
									}
								}
							}
						}
					});
				}
			}
		}

		public void reset(View v)
		{
			gameOver = false;
			playCount = 0;
			infoTV.setText(R.string.xturn);
			winnerTV.setVisibility(View.GONE);
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					tileImage[i][j].setImageResource(R.drawable.droid);
					board.played[i][j] = false;
				}
			}
		}
	}
