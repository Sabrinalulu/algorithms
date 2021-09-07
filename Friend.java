import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue; 
import java.util.ArrayDeque;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    // public boolean canBeconnected(Friend friend){
    //     if(this.email.equals(friend.email)) return true;
    //     for(final Friend next: this.friends) 
    //        if(next.canBeconnected(friend)) return true;
    //      return false;
    // } thorws error
    public boolean canBeConnected(Friend friend) {
        Set<String> visited = new HashSet<>();
        Queue<Friend> q = new ArrayDeque<>();
        q.add(this); // put current node into queue (a)
        visited.add(this.email); // to identify a person if is already visited
        
        while(!q.isEmpty()){
            Friend current = q.poll();
            if(current.email.equals(friend.email)) return true;
            
            for(Friend nextone : current.friends){ // go through all friends (linked nodes)
                boolean added = visited.add(nextone.email);
                if(added){
                    q.add(nextone);
                }
            }
            
        }
        
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}
