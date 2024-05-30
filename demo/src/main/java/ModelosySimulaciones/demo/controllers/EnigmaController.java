package ModelosySimulaciones.demo.controllers;

import ModelosySimulaciones.demo.service.EnigmaService;
import ModelosySimulaciones.demo.dto.EnigmaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class EnigmaController {

    @Autowired
    private EnigmaService enigmaService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/set-rotors")
    @ResponseBody
    public EnigmaResponse setRotors(
            @RequestParam String rotor1Letter,
            @RequestParam String rotor2Letter,
            @RequestParam String rotor3Letter) {
        boolean success = enigmaService.configureRotors(rotor1Letter, rotor2Letter, rotor3Letter);
        return new EnigmaResponse(success);
    }

    @GetMapping("/encrypt")
    public String showEncryptPage() {
        return "encrypt";
    }

    @PostMapping("/encrypt")
    @ResponseBody
    public String encrypt(@RequestBody String plaintext) {
        return enigmaService.encrypt(plaintext);
    }

    @PostMapping("/decrypt")
    @ResponseBody
    public String decrypt(@RequestBody String ciphertext) {
        return enigmaService.decrypt(ciphertext);
    }
}
