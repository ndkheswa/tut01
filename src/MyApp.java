public class MyApp implements Consumer {
    private MessageService messageService;

    MyApp(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMessages(String msg, String rec) {
        messageService.sendMessage(msg, rec);
    }
}
