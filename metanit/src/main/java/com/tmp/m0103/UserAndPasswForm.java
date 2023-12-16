package com.tmp.m0103;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UserAndPasswForm {
    public void BuildAndShow( Stage primaryStage) {
        // на русском:
        // Создание формы в JavaFX
        // https://russianblogs.com/article/7814160277/
        // на английском:
        // Creating a Form in JavaFX
        // https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm


        // Для формы входа используйте GridPane (Компоновка), поскольку она позволяет создавать
        // гибкие сетки строк и столбцов для размещения элементов управления в нем. Вы можете поместить
        // элемент управления в любую ячейку сетки и при необходимости создать ячейки диапазона управления.
        GridPane grid = new GridPane( );

        // Свойство Alignment (выравнивания) меняет положение сетки по умолчанию с верхнего левого угла сцены на центр.
        grid.setAlignment( Pos.CENTER);

        // Свойство gap управляет расстоянием между строками и столбцами
        grid.setHgap( 10);
        grid.setVgap( 10);

        // свойство padding управляет пространством вокруг краев панели сетки. Иллюстрации расположены в порядке сверху, справа, снизу и слева.
        grid.setPadding( new Insets(25, 25, 25, 25));
        Scene scene = new Scene( grid, 300, 275);
        primaryStage.setScene( scene);

        // При использовании панели сетки вы можете отображать линии сетки, что полезно для отладки.
        // В этом случае вы можете вызвать grid.setGridLinesVisible( true).
        // Затем, когда вы запускаете приложение, вы видите строки столбцов сетки и строк и свойства промежутка.
        //grid.setGridLinesVisible( true);

        // создает Text Не редактируемый объект, установите текст в Welcome
        // назначьте его переменной с именем scenetitle
        Text scenetitle = new Text("Welcome");
        // Когда стили привязаны к переменным, целесообразно использовать встроенные стили.
        // Но лучше (здесь не так) использовать таблицы стилей для лучшего оформления элементов пользовательского интерфейса.
        scenetitle.setFont( Font.font("Tahoma", FontWeight.NORMAL, 20));

        // Добавим в grid (макет) scenetitle.
        // Столбцы и строки в сетке нумеруются с нуля, и scenetitle Добавлено в столбец 0, строку 0.
        // Последние два параметра метода устанавливают для диапазона столбцов значение 2, а для диапазона строк 1.
        grid.add( scenetitle, 0, 0, 2, 1);

        // Создайте в следующей строке Label Объект, содержащий первый User Name
        Label userName = new Label("User Name:");
        // Столбец 0, строка 1.
        grid.add( userName, 0, 1);

        // TextField - Редактируемый объект.
        TextField userTextField = new TextField( );
        // Текстовое поле добавляется на панель сетки в столбце 1, строка 1.
        grid.add(userTextField, 1, 1);

        // Поля и метки паролей будут созданы и добавлены в панель сетки аналогичным образом.
        Label pw = new Label("Password:");
        grid.add( pw, 0, 2);

        PasswordField pwBox = new PasswordField( );
        grid.add( pwBox, 1, 2);

        // Сначала создайте кнопку. Первая строка создает btn с надписью Sign in.
        Button btn = new Button("Sign in");
        // Создает один HBox в пикселях hbBtn интервал именованной панели макета 10.
        HBox hbBtn = new HBox(10);
        // HBox панель устанавливает выравнивание кнопок, которое отличается от выравнивания,
        // примененного к другим элементам управления на панели сетки (нижний правый угол),
        // который является общим местом для кнопок, которые выполняют действия, влияющие на всю форму.
        // Значение атрибута Pos.BOTTOM_RIGHT Узел размещает узел вертикально внизу пространства и горизонтально по правому краю пространства.
        hbBtn.setAlignment( Pos.BOTTOM_RIGHT);
        // Кнопка btn была добавлена как child (детская - наследник) для HBox панели.
        hbBtn.getChildren( ).add( btn);
        // HBox Панель будет добавлена в сетку в столбец 1, строку 4.
        grid.add( hbBtn, 1, 4);

        // Добавим Text контрол для отображения сообщений.
        // Мы не увидим текстовое сообщение (пока не сделаем ещё что-то).
        final Text actiontarget = new Text( );
        grid.add( actiontarget, 1, 6);

        // setOnAction() метод используется для регистрации обработчика событий когда кнопка нажата.
        btn.setOnAction( new EventHandler< ActionEvent>( ) {
            @Override
            public void handle( ActionEvent e) {
                actiontarget.setFill( Color.FIREBRICK); // Цвет объекта установлен на огнеупорный кирпич красного цвета.
                actiontarget.setText( "Sign in button pressed"); // Устанавливает actiontarget при ажатии на Sign in.
            }
        });

        primaryStage.setTitle( "JavaFX Welcome");
        primaryStage.show( );
    }
}
