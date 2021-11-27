package ca.qc.johnabbott.finalproject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.databinding.ListItemCartItemBinding;

import java.text.NumberFormat;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link CartItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CartItemRecyclerViewAdapter extends RecyclerView.Adapter<CartItemRecyclerViewAdapter.ViewHolder> {

    private final List<CartItem> mValues;

    public CartItemRecyclerViewAdapter(List<CartItem> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemCartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(mValues.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemCartItemBinding binding;
        private CartItem mItem;

        public ViewHolder(ListItemCartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CartItem cartItem, int position) {
            mItem = cartItem;
            binding.imageView3.setImageResource(R.drawable.cart_placeholder_image);
            binding.titleTextView.setText(cartItem.getProduct().getName());
            binding.descriptionTextView.setText(cartItem.getProduct().getDescription());
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            binding.priceTextView.setText(formatter.format(cartItem.getUnitPrice() * cartItem.getQuantity()));
            binding.quantityNumberTextView.setText(String.valueOf(cartItem.getQuantity()));

            binding.quantityMinusButton.setOnClickListener(view -> {
                int old = mItem.getQuantity();
                if(old <= 1) {
                    return;
                }
                mItem.setQuantity(--old);
                notifyItemChanged(position);
            });

            binding.quantityPlusButton.setOnClickListener(view -> {
                int old = mItem.getQuantity();
                mItem.setQuantity(++old);
                notifyItemChanged(position);
            });

            binding.removeButton.setOnClickListener(view -> {
                mValues.remove(position);
                notifyItemRemoved(position);
            });
        }
    }
}