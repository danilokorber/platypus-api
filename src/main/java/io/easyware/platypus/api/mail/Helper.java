package io.easyware.platypus.api.mail;

import io.easyware.platypus.api.mail.objects.Message;
import io.easyware.platypus.api.mail.objects.Thread;

import java.util.ArrayList;

public class Helper {

    private ArrayList<Thread> threads;

    public ArrayList<Thread> threadsOnly(ArrayList<Message> messages) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        ArrayList<String> threadsIds = new ArrayList<String>();

        messages.stream().forEach(message -> {
            String currentThreadId = message.getThreadId();
            if (!threadsIds.contains(currentThreadId)) {
                Thread newThread = new Thread();
                newThread.setId(currentThreadId);
                threadsIds.add(currentThreadId);
                threads.add(newThread);
            }
            Thread currentThread = (Thread) threads.stream().filter(t -> t.getId().equals(currentThreadId)).findFirst().orElse(null);
            if (currentThread != null) {
                if (message.isUnseen()) { currentThread.setUnseen(true); }
                if (message.getDate().after(currentThread.getDate())) {
                    currentThread.setFrom(message.getFrom());
                }
                currentThread.setHasAttachments(message.hasAttachments());
                currentThread.setSubject(message.getSubject());
                currentThread.setDate(message.getDate());
            }
            currentThread.sizePlusOne();
        });
        return threads;
    }

//    public ArrayList<Thread> messagesToThreads(ArrayList<Message> messages) {
//        ArrayList<Thread> threads = new ArrayList<Thread>();
//        ArrayList<String> threadsIds = new ArrayList<String>();
//
//        messages.stream().forEach(message -> {
//            String currentThreadId = message.getThreadId();
//            //System.out.print(currentThreadId + ": ");
//            if (!threadsIds.contains(currentThreadId)) {
//                Thread newThread = new Thread();
//                newThread.setId(currentThreadId);
//                threadsIds.add(currentThreadId);
//                threads.add(newThread);
//            }
//            Thread currentThread = (Thread) threads.stream().filter(t -> t.getId().equals(currentThreadId)).findFirst().orElse(null);
//            if (currentThread != null) {
//                if (message.isUnseen()) { currentThread.setUnseen(true); }
//                currentThread.addMessage(message);
//                //System.out.println(currentThread.getMessages().size());
//            }
//        });
//        return threads;
//    }

}
