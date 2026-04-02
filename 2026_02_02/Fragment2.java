import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView emailText = view.findViewById(R.id.emailText);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView surnameText = view.findViewById(R.id.surnameText);

        if (getArguments() != null) {
            String email = getArguments().getString("email");
            String name = getArguments().getString("name");
            String surname = getArguments().getString("surname");

            emailText.setText("Email: " + email);
            nameText.setText("Imię: " + name);
            surnameText.setText("Nazwisko: " + surname);
        }
    }
}
