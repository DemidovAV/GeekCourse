import session.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.startSession();
            sessionManager.startDBManagement();

        } finally {
            sessionManager.stopSession();
        }
    }

}
