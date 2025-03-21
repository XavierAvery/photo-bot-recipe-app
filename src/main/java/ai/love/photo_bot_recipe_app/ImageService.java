package ai.love.photo_bot_recipe_app;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

//    public ImageResponse generateImage(String prompt) {  // NOTE: Generates a single image based on the prompt
//        return openAiImageModel.call(new ImagePrompt(prompt));
//    }

    public ImageResponse generateImage(String prompt, String quality, int n, int width, int height) {
//        return openAiImageModel.call(new ImagePrompt(prompt,
//                OpenAiImageOptions.builder()
//                            .withModel("dall-e-2")
//                            .quality("hd")
//                            .withN(3)
//                            .withHeight(1024)
//                            .withWidth(1024).build())
//        );  // NOTE: Generates 3 images based on the prompt with the builder and without the parameters;

        return openAiImageModel.call(new ImagePrompt(prompt,
                OpenAiImageOptions.builder()
                            .withModel("dall-e-2")
                            .quality(quality)
                            .withN(n)
                            .withHeight(height)
                            .withWidth(width).build())
        );  // NOTE: Generates n images based on the prompt with the builder and with the parameters;


    }

}
