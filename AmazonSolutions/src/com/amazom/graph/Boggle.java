package com.amazom.graph;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

public class Boggle {

	public void game(Set<String> dictionary, char board[][]) {

		boolean visited[][] = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				StringBuffer buffer = new StringBuffer();
				DFS(dictionary, i, j, board, visited, buffer);
			}
		}

	}

	private void DFS(Set<String> set, int i, int j, char[][] board,
			boolean[][] visited, StringBuffer buffer) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
			return;
		}

		if (visited[i][j] == true)
			return;

		visited[i][j] = true;

		buffer.append(board[i][j]);

		if (set.contains(buffer.toString())) {
			System.out.println("  String is " + buffer.toString());
		}

		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				DFS(set, k, l, board, visited, buffer);// Recursion for the overlapping Strings
			}
		}

		buffer.deleteCharAt(buffer.length() - 1);
		visited[i][j] = false;

	}

	public static void main(String args[]) {
		Boggle boggle = new Boggle();
		char[][] board = { { 't', 'a', 's', 'g' }, { 'l', 'u', 'n', 'h' },
				{ 't', 'e', 'i', 'a' }, { 'a', 'w', 's', 'r' }

		};

		Set<String> dictionary = new HashSet<String>();

		dictionary.add("tushar");
		dictionary.add("anisweta");
		boggle.game(dictionary, board);

	}
}
