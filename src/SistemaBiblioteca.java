import java.util.ArrayList;


class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }


    public void imprimirDetalhes() {
        System.out.println("Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone);
    }
}


class Cliente extends Pessoa {
    private int idCliente;
    private ArrayList<Livro> livrosEmprestados;

    public Cliente() {
        livrosEmprestados = new ArrayList<>();
    }


    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public ArrayList<Livro> getLivrosEmprestados() { return livrosEmprestados; }


    public void emprestarLivro(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println("ID do Cliente: " + idCliente + ", Livros Emprestados: " + livrosEmprestados.size());
    }
}


class Livro {
    private String titulo;
    private String autor;
    private int idLivro;
    private boolean disponivel;


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getIdLivro() { return idLivro; }
    public void setIdLivro(int idLivro) { this.idLivro = idLivro; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}


class Biblioteca {
    private ArrayList<Livro> listaLivros;
    private ArrayList<Cliente> listaClientes;

    public Biblioteca() {
        listaLivros = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }


    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public void removerLivro(Livro livro) {
        listaLivros.remove(livro);
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }


    public void emprestarLivro(int idCliente, int idLivro) {
        Cliente cliente = null;
        Livro livro = null;

        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                cliente = c;
                break;
            }
        }

        for (Livro l : listaLivros) {
            if (l.getIdLivro() == idLivro && l.isDisponivel()) {
                livro = l;
                break;
            }
        }

        if (cliente != null && livro != null) {
            cliente.emprestarLivro(livro);
            livro.setDisponivel(false);
        }
    }

    public void devolverLivro(int idCliente, int idLivro) {
        Cliente cliente = null;
        Livro livro = null;

        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                cliente = c;
                break;
            }
        }

        for (Livro l : listaLivros) {
            if (l.getIdLivro() == idLivro) {
                livro = l;
                break;
            }
        }

        if (cliente != null && livro != null) {
            cliente.devolverLivro(livro);
            livro.setDisponivel(true);
        }
    }
}
