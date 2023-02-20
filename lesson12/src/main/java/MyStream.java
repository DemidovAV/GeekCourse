import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;

//public class MyStream  implements Runnable {
//    @Override
//    public void run() {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//        Session session = null;
////        try {
////            for (int i = 0; i < 20000; i++) {
////                session.beginTransaction();
////                int random = Math.random() *
////                Item item = session.createQuery("FROM Item WHERE id = :id")
////                        .setLockMode(LockModeType.PESSIMISTIC_WRITE)
////                        .setParameter("id", int j = )
////            }
////        }
////    }
////}
