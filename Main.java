package application;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane root = new Pane();
		root.setStyle("-fx-background-color: #F5DEB3;\r\n");
	    Pane pane = new Pane();
        root.getChildren().add(pane);
        pane.setPrefSize(600, 600);
        pane.setTranslateX(520);
        pane.setTranslateY(200);
        
        
		Button compress = new Button("Compress");
		compress.setPrefSize(150, 50);
		compress.setStyle("-fx-background-color: #0000FF;\r\n" + " -fx-background-radius:100;\r\n");
		pane.getChildren().add(compress);
		compress.setTranslateX(70);
		compress.setTranslateY(-50);
		compress.setFont(new Font(15));

		Button decompress = new Button("Decompress");
		decompress.setPrefSize(150, 50);
		decompress.setStyle("-fx-background-color: #0000FF;\r\n" + " -fx-background-radius:100;\r\n");
		pane.getChildren().add(decompress);
		decompress.setTranslateX(370);
		decompress.setTranslateY(-50);
		decompress.setFont(new Font(15));

		TextArea ta = new TextArea();
		ta.setPrefSize(600, 440);
		pane.getChildren().add(ta);
		ta.setTranslateX(0);
		ta.setTranslateY(50);
		ta.setFont(new Font(15));

		compress.setOnAction(e -> {
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(primaryStage);
			try {
			Huffman.compress(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Label l = new Label("Compression is done");
			l.setFont(new Font(15));
			pane.getChildren().add(l);
			l.setTranslateX(80);
			l.setTranslateY(510);

			
			
			ImageView i = new ImageView("https://cdn-icons-png.flaticon.com/512/3888/3888671.png");
			i.setFitHeight(20);
			i.setFitWidth(20);
			pane.getChildren().add(i);
			i.setTranslateX(222);
			i.setTranslateY(510);
			

			Button statistics = new Button("Show statistics");
			statistics.setPrefSize(180, 50);
			statistics.setStyle("-fx-background-color: #00BFFF;\r\n" + "        -fx-background-radius:100;\r\n");
			pane.getChildren().add(statistics);
			statistics.setTranslateX(250);
			statistics.setTranslateY(500);
			statistics.setFont(new Font(15));

			statistics.setOnAction(s -> {
				ta.appendText("File path: " + file.getPath() + "\nCompressed file path: " + Huffman.outFileName
						+ "\n\nASCII\tCharacter\t\tFrequency\tHuffCode\n");
				for (int k = 0; k < Huffman.huffCodeArray.length; k++) {
					if((int)Huffman.huffCodeArray[k].character==10 || (int)Huffman.huffCodeArray[k].character==9)
						continue;
					ta.appendText(String.valueOf((int) Huffman.huffCodeArray[k].character) + "\t\t  "
							+ Huffman.huffCodeArray[k].character + "\t\t\t"
							+ String.valueOf(Huffman.huffCodeArray[k].counter) + "\t\t\t"
							+ Huffman.huffCodeArray[k].huffCode+"\n");
				}
			});

		});
		
		
		decompress.setOnAction(e->{
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(primaryStage);
			Huffman.deCompress(file);
			Label l = new Label("Decompression is done");
			l.setFont(new Font(15));
			pane.getChildren().add(l);
			l.setTranslateX(80);
			l.setTranslateY(510);

			ImageView i = new ImageView("https://cdn-icons-png.flaticon.com/512/3888/3888671.png");
			i.setFitHeight(20);
			i.setFitWidth(20);
			pane.getChildren().add(i);
			i.setTranslateX(235);
			i.setTranslateY(510);
		});
		Scene scene = new Scene(root);

		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Compress & Decompress file");
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
