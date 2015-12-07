package com.example.acer.memecreatot;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatDialogFragment
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment{

    //Eerst variabelen maken.
    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString());

        }
    }

    /*Wanneer deze java class wordt geopend wordt een relatie gelegd met
    fragment "top_section_fragment".
    */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        /*De View heet nu view en er worden relaties geled naar de diverse widget. */
        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button =(Button) view.findViewById(R.id.button);

        //Wordt de Button button geclicked dan wordt de methode buttonClicked aangeroepen.
        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    //Als de button wordt geclicked gebeurt dit.
    public void buttonClicked(View view){
        activityCommander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }

}
