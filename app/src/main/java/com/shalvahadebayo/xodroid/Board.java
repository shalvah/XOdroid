package com.shalvahadebayo.xodroid;

public class Board
	{
		public char[][] tiles;
		public boolean[][] played;
		public char winner;
		public boolean full;

		public Board()
		{
			tiles = new char[3][3];
			played = new boolean[3][3];
			full = false;
			winner = '-';
		}

		public void play(int xIndex, int yIndex, char mValue)
		{
			this.tiles[xIndex][yIndex] = mValue;
			played[xIndex][yIndex] = true;
		}

		public boolean isWon()
		{
			if ((tiles[0][0] == tiles[1][1]) && (tiles[1][1] == tiles[2][2]))
			{
				if (played[0][0] && played[1][1] && played[2][2])
				{
					winner = tiles[0][0];
					return true;
				}
			} else if (tiles[0][2] == tiles[1][1] && tiles[1][1] == tiles[2][0])
			{
				if (played[0][2] && played[1][1] && played[2][0])
				{
					winner = tiles[0][2];
					return true;
				}
			} else if (tiles[0][0] == tiles[0][1] && tiles[0][1] == tiles[0][2])
			{
				if (played[0][0] && played[0][1] && played[0][2])
				{
					winner = tiles[0][0];
					return true;
				}
			} else if (tiles[1][0] == tiles[1][1] && tiles[1][1] == tiles[1][2])
			{
				if (played[1][0] && played[1][1] && played[1][2])
				{
					winner = tiles[1][0];
					return true;
				}
			} else if (tiles[2][0] == tiles[2][1] && tiles[2][1] == tiles[2][2])
			{
				if (played[2][0] && played[2][1] && played[2][2])
				{
					winner = tiles[2][0];
					return true;
				}
			} else if (tiles[0][0] == tiles[1][0] && tiles[1][0] == tiles[2][0])
			{
				if (played[0][0] && played[1][0] && played[2][0])
				{
					winner = tiles[0][0];
					return true;
				}
			} else if (tiles[0][1] == tiles[1][1] && tiles[1][1] == tiles[2][1])
			{
				if (played[0][1] && played[1][1] && played[2][1])
				{
					winner = tiles[0][1];
					return true;
				}
			} else if (tiles[0][2] == tiles[1][2] && tiles[1][2] == tiles[2][2])
			{
				if (played[0][2] && played[1][2] && played[2][2])
				{
					winner = tiles[0][2];
					return true;
				}
			}
			return false;
		}

	}
