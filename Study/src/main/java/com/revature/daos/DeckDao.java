package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Deck;
import com.revature.utils.ConnectionUtil;

public class DeckDao implements DeckDaoInterface{

	@Override
	public List<Deck> getAllDecks() {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet results = null;
			
			String sql = "select * from decks;";
			
			Statement s = conn.createStatement();
			
			results = s.executeQuery(sql);
			
			List<Deck> deckList = new ArrayList<>();
			
			while(results.next()) {
				Deck deck = new Deck(
						results.getInt("deck_id"),
						results.getString("deck_name")
						);
				deckList.add(deck);
			}
			return deckList;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong while accessing your database");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addDeck(Deck dk) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "insert into decks (deck_name)" + "values(?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dk.getDeck_name());
			
			ps.executeUpdate();
			
			System.out.println("Deck " + dk.getDeck_name() + " Was added");
			
		}catch (SQLException e) {
			System.out.println("Delete Deck failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeDeck(int dkId) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM decks where deck_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, dkId);
			
			ps.executeUpdate();
			
			System.out.println("Deck " + dkId + " has been deleted");
			
		}catch (SQLException e) {
			System.out.println("Delete deck failed");
			e.printStackTrace();
		}
		
	}

}
