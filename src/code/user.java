package code;

import java.util.Date;

public class user {
    //usuario
    String name;
    String username;
    String password;
    char gender;
    Date regdate;
    int age;
    boolean active;
    private String[] following;
    String[] followers;
   

    //manejo de cuenta
    private static String loggedinuser;

    //seleccionar una cuenta
    private static user selectedacc;
    
    public static user[] getAllUsers() {
    return users; 
}
    
     private tweet[] tweets = new tweet[100]; 
    private int tweetCount = 0;
    public user() {
    }

    private static user users[] = new user[100];

    public user(String nombre, String nombreusuario, String contra, char genero, int edad) {
        name = nombre;
        username = nombreusuario;
        password = contra;
        gender = genero;
        age = edad;
        active = true;
        followers = new String[20];
        following = new String[20];
    }

     public String[] getFollowing() {
        return following; 
    }
     public void addTweet(String tweetText) {
        if (tweetCount < tweets.length) {
            Date currentDate = new Date();  
            tweets[tweetCount] = new tweet(tweetText, this.username, currentDate); 
            tweetCount++;  
        } else {
            System.out.println("Has alcanzado el limite maximo de tweets.");
        }
    }
      public tweet[] getUserTweets() {
        return tweets;
    }
  
    public int getTweetCount() {
        return tweetCount;
    }

     
    public user searchuser(String nombre) {
        for (user u : users) {
            if (u != null && u.username.equals(nombre)) {
                return u;
            }
        }
        return null;
    }

    public boolean adduser(String nombre, String nombreusuario, String contra, char genero, int edad) {
        if (searchuser(nombreusuario) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = new user(nombre, nombreusuario, contra, genero, edad);
                    loggedinuser(nombreusuario);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean logintry(String nombreusuario, String contra) {
        user u = searchuser(nombreusuario);
        if (u != null && u.username.equals(nombreusuario) && u.password.equals(contra)) {
            if (u.active == false) {
                activateacc(nombreusuario);
            }
            loggedinuser(nombreusuario);
            return true;
        }
        return false;
    }

    public void foundusers(String contains, user[] found) {
        int contador = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].username.contains(contains)) {
                if (!users[i].username.equals(loggedinuser) && users[i].isactive()) {
                    found[contador] = users[i];
                    contador++;
                }
            }
        }
    }

    public boolean isactive() {
        return active;
    }

    public int followercount(user user) {
        int count = 0;
        for (int i = 0; i < user.followers.length; i++) {
            if (user.followers[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int followingcount(user user) {
        int count = 0;
        for (int i = 0; i < user.following.length; i++) {
            if (user.following[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void loggedinuser(String nombreusuario) {
        loggedinuser = nombreusuario;
        System.out.println("la cuenta " + loggedinuser + " se ha logueado");
    }

    public void delogguer() {
        System.out.println("la cuenta " + loggedinuser + " esta intentando desloguear");
        loggedinuser = null;
        if (loggedinuser == null) {
            System.out.println("se ha deslogueado con exito");
        }
    }

    public String getLoggedinuser() {
        return loggedinuser;
    }
    
     public static user getLoggedUser() {
        if (loggedinuser != null) {
            for (user u : users) {
                if (u != null && u.username.equals(loggedinuser)) {
                    return u; 
                }
            }
        }
        return null;
     }
      
    
 

    public void deactivateacc(String user) {
        user foundUser = searchuser(user);
        if (foundUser != null) {
            foundUser.active = false;
            delogguer();
            System.out.println("La cuenta " + foundUser.username + " ha sido desactivada");
        }
    }

    public void activateacc(String user) {
        user foundUser = searchuser(user);
        if (foundUser != null) {
            foundUser.active = true;
            System.out.println("La cuenta " + foundUser.username + " ha sido activada");
        }
    }

   
    
    public boolean getstatus(String user) {
        user foundUser = searchuser(user);
        if (foundUser != null) {
            return foundUser.active;
        }
        return false;
    }

    public void selectacc(user user) {
        selectedacc = user;
    }

    //cambiar
    public user loggedacc(String name) {
        user u = searchuser(loggedinuser);
        return u;
    }

    public boolean followsuser(user user) {
        user u = searchuser(loggedinuser);
        for (int i = 0; i < u.following.length; i++) {
            if (u.following[i] != null && u.following[i].equals(user.username)) {
                return true;
            }
        }
        return false;
    }

    public void followacc(user user) {
        user u = searchuser(loggedinuser);
        for (int i = 0; i < u.following.length; i++) {
            if (u.following[i] == null) {
                u.following[i] = user.username;
                break;
            }
        }
        for (int i = 0; i < user.followers.length; i++) {
            if (user.followers[i] == null) {
                user.followers[i] = loggedinuser;
                break;
            }
        }
    }

    public void unfollowacc(user user) {
        user u = searchuser(loggedinuser);
        for (int i = 0; i < u.following.length; i++) {
            if (u.following[i] != null && u.following[i].equals(user.username)) {
                u.following[i] = null;
                break;
            }
        }
        for (int i = 0; i < user.followers.length; i++) {
            if (user.followers[i] != null && user.followers[i].equals(loggedinuser)) {
                user.followers[i] = null;
                break;
            }
        }
    }

    //chat es esto real
    public void showFollowers() {
        user u = searchuser(loggedinuser);
        System.out.println("Followers of " + u.username + ":");
        for (String follower : u.followers) {
            if (follower != null) {
                System.out.println(follower);
            }
        }
    }

    public void showFollowing() {
        user u = searchuser(loggedinuser);
        System.out.println("Following of " + u.username + ":");
        for (String followee : u.following) {
            if (followee != null) {
                System.out.println(followee);
            }
        }
    }
}
