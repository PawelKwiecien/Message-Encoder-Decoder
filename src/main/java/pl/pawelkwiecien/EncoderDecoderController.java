package pl.pawelkwiecien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncoderDecoderController {


    @RequestMapping("/service")
    public String service(Model messageModel) {
        EncoderDecoder encoderDecoder = new EncoderDecoder();
        messageModel.addAttribute("message", encoderDecoder);
        return "coding";
    }

    @RequestMapping(value = "/encode")
    public String encode(
            @ModelAttribute("message") EncoderDecoder message,
            Model messageModel) {
        if (message.getMode() == 'E') {
            message.setOutputMessage(message
                    .encode(message.getInputMessage(),
                            message.getCodingKey()));
            messageModel.addAttribute("message", message);
        } else if (message.getMode() == 'D') {
        message.setOutputMessage(message
                .decode(message.getInputMessage(),
                        message.getCodingKey()));
        messageModel.addAttribute("message", message);
        }
        return "coding";
    }

}
