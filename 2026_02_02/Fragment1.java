import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        EditText email = view.findViewById(R.id.emailEditText);
        EditText name = view.findViewById(R.id.nameEditText);
        EditText surname = view.findViewById(R.id.surnameEditText);
        Button button = view.findViewById(R.id.submitButton);

        button.setOnClickListener(v -> {

            String emailText = email.getText().toString();
            String nameText = name.getText().toString();
            String surnameText = surname.getText().toString();

            // sprawdzanie pustych pól
            if (emailText.isEmpty() || nameText.isEmpty() || surnameText.isEmpty()) {
                Toast.makeText(getActivity(), "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                return;
            }

            // sprawdzanie emaila
            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(getActivity(), "Niepoprawny email", Toast.LENGTH_SHORT).show();
                return;
            }

            // przekazanie danych
            Bundle bundle = new Bundle();
            bundle.putString("email", emailText);
            bundle.putString("name", nameText);
            bundle.putString("surname", surnameText);

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
