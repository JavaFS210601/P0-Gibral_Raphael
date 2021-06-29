package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Card;
import com.revature.models.Deck;
import com.revature.utils.ConnectionUtil;

public class CardDao implements CardDaoInterface {

	@Override
	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet results = null;
			
			String sql = "select * from cards;";
			
			Statement s = conn.createStatement();
			
			results = s.executeQuery(sql);
			
			List<Card> cardList = new ArrayList<>();
			
			while(results.next()) {
				Card card = new Card(
						results.getInt("card_id"),
						results.getString("card_q"),
						results.getString("card_a"),
						results.getBoolean("is_correct"),
						results.getInt("deck_id_fk")
						);
				cardList.add(card);
			}
			return cardList;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong while accessing your database");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCard(Card cd) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "insert into cards (card_q, card_a, is_correct, deck_id_fk)" + "values(?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cd.getCard_q());
			ps.setString(2, cd.getCard_a());
			ps.setBoolean(3, cd.isIs_correct());
			ps.setInt(4, cd.getDeck_id_fk());
			
			ps.executeUpdate();
			
			System.out.println("Card " + cd.getCard_q() + " Was added");
			
		}catch (SQLException e) {
			System.out.println("Add card has failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeCard(int cdId) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM cards where card_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cdId);
			
			ps.executeUpdate();
			
			System.out.println("Card " + cdId + " has been deleted");
			
		}catch (SQLException e) {
			System.out.println("delete card has failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeIsCorrect(int cardId) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE cards SET is_correct = true WHERE card_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cardId);

			ps.executeUpdate();
			
			System.out.println("Card is correct is false");
			
		}catch (SQLException e) {
			System.out.println("Change isCorrect Failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public void resetIsCorrect() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE cards SET is_correct = false;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			
			System.out.println("All Card is correct are false");
			
		}catch (SQLException e) {
			System.out.println("Change isCorrect Failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Card> getCards(int dkId) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet results = null;
			
			String sql = "select * from cards where deck_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, dkId);
			
			results = ps.executeQuery();
			
			List<Card> cardList = new ArrayList<>();
			
			while(results.next()) {
				Card card = new Card(
						results.getInt("card_id"),
						results.getString("card_q"),
						results.getString("card_a"),
						results.getBoolean("is_correct"),
						results.getInt("deck_id_fk")
						);
				cardList.add(card);
			}
			return cardList;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong while accessing your database");
			e.printStackTrace();
		}
		return null;
	}

}
