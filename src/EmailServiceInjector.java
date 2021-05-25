public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyApp(new EmailServiceImpl());
    }
}
