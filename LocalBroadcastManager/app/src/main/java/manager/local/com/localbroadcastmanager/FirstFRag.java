package manager.local.com.localbroadcastmanager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFRag extends Fragment {

    View view;
    EditText texttopass;
    Button passButton;

    public FirstFRag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first_frag, container, false);
        initViews();
        passButtonClick();
        return view;
    }

    private void passButtonClick() {
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToPass = texttopass.getText().toString();
                if (!textToPass.equals("")){
                    Intent intent = new Intent("event");
                    intent.putExtra("abc",textToPass);
                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
                    getFragmentManager().popBackStackImmediate();

                }
                else {
                    texttopass.setError("Can't Be Null");
                }

            }
        });
    }

    private void initViews() {
        texttopass = view.findViewById(R.id.texttopass);
        passButton = view.findViewById(R.id.passButton);
    }

}
