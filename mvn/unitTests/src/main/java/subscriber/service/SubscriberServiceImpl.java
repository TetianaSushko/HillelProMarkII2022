package subscriber.service;

import subscriber.Subscriber;
import subscriber.service.SubscriberService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberServiceImpl implements SubscriberService {
    @Override
    public List<Subscriber> checkTimeCityConversation(List<Subscriber> subscriber, int timeCity) {
       List<Subscriber> sbList = new ArrayList<>();
        for (Subscriber subscribers : subscriber) {
            if (subscribers.getTimeCityConversation() >= timeCity) {
                sbList.add(subscribers);
            }
        }
        return sbList;


//        return subscriber.stream()
//                .filter(s -> s.getTimeCityConversation() >= timeCity)
//                .collect(Collectors.toList());
    }

    @Override
    public List<Subscriber> checkUsersWhoUseIntercityConnection(ArrayList<Subscriber> subscriber) {
        System.out.println("Users who used inter city communication: ");
        System.out.println();
        for (Subscriber subscribers : subscriber) {
            if (subscribers.getTimeIntercityConversation() > 0) {
                System.out.println(subscribers);
            }
        }
        return  null;
    }

    @Override
    public List<Subscriber> alphabetSort(ArrayList<Subscriber> subscriber, char letter) {
        System.out.println("Displaying subscribers whose patronymic starts with a letter: " + letter);
        for (Subscriber subscribers : subscriber) {
            char[] arrPatronymic = subscribers.getPatronymic().toCharArray();
            if (arrPatronymic[0] == letter) {
                System.out.println("Patronymic: " + subscribers.getPatronymic() + ". First name: " +
                        subscribers.getName() + ". Surname: " + subscribers.getSurname() +
                        ". Number of phone: " + subscribers.getPhoneNumber() + ". Balance: " + subscribers.getBalance());
            }
        }
        return null;
    }

    @Override
    public int checkInternetTraffic(ArrayList<Subscriber> subscriber, String city) {
        System.out.println("The summary internet traffic: " + city);
        int result = 0;
        for (Subscriber subscribers : subscriber) {
            if(subscribers.getCity().equals(city)){
                result += subscribers.getInternetTraffic();
            }

        }
        return result;
    }

    @Override
    public int numberOfAbonentWithNegativeBalance(ArrayList<Subscriber> subscriber) {
        System.out.println("Users who have negative balance: ");
        int count = 0;
        for (Subscriber subscribers : subscriber) {
            if (subscribers.getBalance() < 0) {
                count++;
            }
        }
        return count;
    }
}
