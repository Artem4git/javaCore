package exception._4_3_7;

/*

Вам необходимо описать набор классов, каждый из которых является MailService:

1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
 чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц,
  а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
  У UntrustworthyMailWorker должен быть конструктор от массива MailService (результат вызова processMail
   первого элемента массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService,
   который возвращает ссылку на внутренний экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.

2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
 Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
  Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
   (в выражениях нужно заменить части в фигурных скобках на значения полей почты):

2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
 Detected target mail correspondence: from {from} to {to} "{message}"

2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}

3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
 Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
  Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок,
   которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую,
    такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".

4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
  ("weapons" и "banned substance"), то он бросает IllegalPackageException.
   Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
    Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.

Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен во внешний класс,
 который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено несколько удобных констант
  и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или письмом является
   Sendable объект воспользуйтесь оператором instanceof.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
        //UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new MailService[] { spy, thief, inspector });
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {

            MailPackage mailPackage;

            if (mail instanceof MailPackage) {
                mailPackage = (MailPackage) mail;

                if (mailPackage.getContent().getContent().contains(WEAPONS) || mailPackage.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }

                if (mailPackage.getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }

            }
            return mail;
        }
    }

    public static class Thief implements MailService {

        private int value;

        private int count;

        public Thief(int value) {
            this.value = value;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage mailPackage;

            if (mail instanceof MailPackage) {
                mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() > value) {
                    this.count = getStolenValue() + mailPackage.getContent().getPrice();
                    return new MailPackage(mailPackage.from, mailPackage.to, new Package("stones instead of ".concat(mailPackage.getContent().getContent()), 0));
                }
            }

            return mail;
        }

        public int getStolenValue() {
            return count;
        }
    }

    public static class Spy implements MailService {

        public static Logger LOGGER;

        public Spy(Logger logger) {
            this.LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailMessage mailMessage = null;

            if (mail instanceof MailMessage) {
                mailMessage = (MailMessage) mail;

                if (mailMessage.getFrom().equals(AUSTIN_POWERS) || mailMessage.getTo().equals(AUSTIN_POWERS)) {
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()});
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{mailMessage.getFrom(), mailMessage.getTo()});
                }
            }

            return mailMessage;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

        private RealMailService realMailService;

        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            realMailService = new RealMailService();
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable sendable = mailServices[0].processMail(mail);
            for (int i = 1; i < mailServices.length; i++) {
                sendable = mailServices[i].processMail(sendable);
            }

            return getRealMailService().processMail(sendable);
        }
    }
}
