package code;

import java.util.Date;
import javax.swing.JPanel;

public class tweet {

    String text;
    String Author;
    Date date;
    private static tweet[] tweets = new tweet[100];
    public static user users[] = new user[100];

    public tweet(String text, String author, Date date) {
        this.text = text;
        this.Author = author;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getDate() {
        return date;
    }

    public static tweet[] obtenerTweets(user usuario) {
        int totalTweets = usuario.getTweetCount();
        //Aqui verifico si es que sigo a esa persona
        String[] siguiendo = usuario.getFollowing();
        for (String seguido : siguiendo) {
            user seguidoUser = usuario.searchuser(seguido);
            if (seguidoUser != null) {
                totalTweets += seguidoUser.getTweetCount();
            }
        }//Implementan mis tweets
        tweet[] todosLosTweets = new tweet[totalTweets];
        int tweetcont = 0;
        for (int tweetactual = 0; tweetactual < usuario.getTweetCount(); tweetactual++) {
            todosLosTweets[tweetcont++] = usuario.getUserTweets()[tweetactual];
        }//Implementar Tweets de personas que sigo
        for (String seguido : siguiendo) {
            user seguidoUser = usuario.searchuser(seguido);
            if (seguidoUser != null) {
                for (int contTweetseguido = 0; contTweetseguido < seguidoUser.getTweetCount(); contTweetseguido++) {
                    todosLosTweets[tweetcont++] = seguidoUser.getUserTweets()[contTweetseguido];
                }
            }
        }//Ordenar los tweets
        for (int contadorTweet = 0; contadorTweet < totalTweets - 1; contadorTweet++) {
            for (int contadorcomp = 0; contadorcomp < totalTweets - 1 - contadorTweet; contadorcomp++) {
                if (todosLosTweets[contadorcomp].getDate().compareTo(todosLosTweets[contadorcomp + 1].getDate()) < 0) {
                    tweet temp = todosLosTweets[contadorcomp];
                    todosLosTweets[contadorcomp] = todosLosTweets[contadorcomp + 1];
                    todosLosTweets[contadorcomp + 1] = temp;
                }
            }
        }

        return todosLosTweets;
    }

    public static tweet[] obtenerMenciones(user usuario) {
        String nombreUsuarioLogueado = usuario.getLoggedinuser();
        tweet[] tweetsConMencion = new tweet[100];
        int contadorDeMenciones = 0;
        for (user usuarioActual : users) {
            if (usuarioActual != null) {
                for (tweet tweetActual : usuarioActual.getUserTweets()) {
                    if (tweetActual != null && tweetActual.getText().contains("@" + nombreUsuarioLogueado)) {
                        tweetsConMencion[contadorDeMenciones++] = tweetActual;
                    }
                }
            }
        }
        tweet[] mencionesFinales = new tweet[contadorDeMenciones];
        for (int indice = 0; indice < contadorDeMenciones; indice++) {
            mencionesFinales[indice] = tweetsConMencion[indice];
        }

        return mencionesFinales;
    }

    public static tweet[] buscarHashtag(String hashtag) {
        tweet[] tweets = new tweet[100];
        int contadorDeHashtags = 0;
        for (user usuarioActual : users) {
            if (usuarioActual != null) {
                for (tweet tweetActual : usuarioActual.getUserTweets()) {
                    if (tweetActual != null && tweetActual.getText().contains("#" + hashtag)) {
                        tweets[contadorDeHashtags++] = tweetActual;
                    }
                }
            }
        }
        tweet[] tweetsreturn = new tweet[contadorDeHashtags];
        for (int i = 0; i < contadorDeHashtags; i++) {
            tweetsreturn[i] = tweets[i];
        }
        return tweetsreturn;
    }
}
