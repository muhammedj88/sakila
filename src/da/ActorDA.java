//package da;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Actor;
//
//public class ActorDA implements IActorDA {
//
//	private Connection conn;
//	
//	public ActorDA(){
//		conn=DBUtil.getConnection();
//	}
//
//
//	
//	
//	@Override
//	public void addActot(Actor Actor) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Actor> getAllActors() {
//		List<Actor> actors = new ArrayList<Actor>();
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery( "SELECT * FROM sakila.actor" );
//            while( resultSet.next() ) {
//            	   
//            	Actor actor = new Actor(
//                resultSet.getInt(      "actor_id"),
//                resultSet.getString(   "first_name"),
//                resultSet.getString(   "last_name"),
//                resultSet.getTimestamp("last_update" ) );
//                
//                actors.add(actor);
//            }
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//        	System.out.println(e.getMessage());
//        }
//        return actors;
//
//	}
//
//	@Override
//	public Actor getActorByID(String actor_ID) {
//		 Actor actor = new Actor();
//	        try {
//	            String query = "SELECT * FROM sakila.actor WHERE actor_id=?";
//	            PreparedStatement preparedStatement = conn.prepareStatement( query );
//	            preparedStatement.setInt(1, Integer.parseInt(actor_ID));
//	            ResultSet resultSet = preparedStatement.executeQuery();
//	            while( resultSet.next() ) {
//	            	actor.setId(resultSet.getInt(               "actor_id"));
//	            	actor.setFname(resultSet.getString(         "first_name"));
//	                actor.setLname(resultSet.getString(         "last_name") );
//	                actor.setLast_update(resultSet.getTimestamp("last_update"));
//	            }
//	            resultSet.close();
//	            preparedStatement.close();
//	        } catch (SQLException e) {
//	        	System.out.println(e.getMessage());
//	        }
//	        return actor;
//	    }
//
//	
//
//	@Override
//	public void updateActor(Actor actor) {
//		try {
//            String query = "update sakila.actor set  first_name=?, last_name=?, last_update=? where actor_id=?";
//            PreparedStatement preparedStatement = conn.prepareStatement( query );
//            
//            preparedStatement.setString(   1, actor.getFname() );
//            preparedStatement.setString(   2, actor.getLname() );
//            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));//actor.getLast_update() );
//            preparedStatement.setInt(      4, actor.getId());
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//        	System.out.println(e.getMessage());
//        }
//
//		
//	}
//
//	@Override
//	public void deleteActor(String actorID) {
//		try {
//            String query = "delete from sakila.actor WHERE actor_id=?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, Integer.parseInt(actorID));
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//        } catch (SQLException e) {
//        	 System.out.println(e.getMessage());
//        }
//
//		
//	}
//
//}
