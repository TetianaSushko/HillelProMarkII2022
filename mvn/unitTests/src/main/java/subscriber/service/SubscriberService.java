package subscriber.service;

import subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public interface SubscriberService {
    List<Subscriber> checkTimeCityConversation(List<Subscriber> subscriber, int timeCity);

    List<Subscriber> checkUsersWhoUseIntercityConnection(ArrayList<Subscriber> subscriber);

    List<Subscriber> alphabetSort(ArrayList<Subscriber> subscriber, char letter);

    int checkInternetTraffic(ArrayList<Subscriber> subscriber, String city);

    int numberOfAbonentWithNegativeBalance(ArrayList<Subscriber> subscriber);
}
