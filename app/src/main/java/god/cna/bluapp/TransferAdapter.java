package god.cna.bluapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransferAdapter extends RecyclerView.Adapter<TransferAdapter.TransferViewHolder> {

    private String[] fullNames = new String[10];
    private String[] cardNums = new String[10];
    public TransferAdapter() {
        cardNums[0] = "6104 3374 6547 9874";
        cardNums[1] = "6219 3374 6547 9874";
        cardNums[2] = "5022 3374 6547 9874";
        cardNums[3] = "6037 3374 6547 9874";
        cardNums[4] = "5859 3374 6547 9874";
        cardNums[5] = "6037 3374 6547 9874";
        cardNums[6] = "5022 3374 6547 9874";
        cardNums[7] = "6219 3374 6547 9874";
        cardNums[8] = "6104 3374 6547 9874";
        cardNums[9] = "6104 3374 6547 9874";
        fullNames[0] = "سینا خانبابایی";
        fullNames[1] = "محمد محمدی";
        fullNames[2] = "احسان خان بابایی";
        fullNames[3] = "مهدی وقایع نگار";
        fullNames[4] = "علی رحیم";
        fullNames[5] = "امیر خدابنده لو";
        fullNames[6] = "مهیار خدایی";
        fullNames[7] = "خشایار اکبری";
        fullNames[8] = "پویا قنبری";
        fullNames[9] = "حسن خان بابایی";
    }


    @NonNull
    @Override
    public TransferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransferViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transfer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransferViewHolder holder, int position) {
        holder.bind(fullNames[position], cardNums[position]);
    }

    @Override
    public int getItemCount() {
        return fullNames.length;
    }

    class TransferViewHolder extends RecyclerView.ViewHolder {
        TextView txtFullName, txtCardNumber;

        public TransferViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFullName = itemView.findViewById(R.id.transfer_fullname);
            txtCardNumber = itemView.findViewById(R.id.transfer_card_number);
        }

        public void bind(String fullName, String cardNumber) {
            txtFullName.setText(fullName);
            txtCardNumber.setText(cardNumber);
        }
    }
}
