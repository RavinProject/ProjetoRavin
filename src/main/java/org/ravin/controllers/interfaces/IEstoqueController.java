/**
 * Interface para definir a funcionalidade de um controlador de estoque.
 *
 * <p>Essa interface estende {@code IController<Estoque>} para fornecer funcionalidades específicas para gerenciar um estoque.
 * As operações adicionais incluem a recuperação de um estoque por código e a verificação se um estoque já foi cadastrado.
 *
 * @see IController
 */
package org.ravin.controllers.interfaces;

import org.ravin.models.Estoque;
import org.ravin.utils.exceptions.EntidadeNaoEncontradaException;

public interface IEstoqueController extends IController<Estoque>{
    /**
     * Recupera um estoque por seu código.
     *
     * @param codigo O código do estoque a ser recuperado.
     * @return O objeto Estoque correspondente ao código fornecido.
     * @throws EntidadeNaoEncontradaException Se o estoque com o código fornecido não for encontrado.
     */
    Estoque recuperarPorCodigo(String codigo) throws EntidadeNaoEncontradaException;
    /**
     * Verifica se um estoque já foi cadastrado.
     *
     * @param codigo O código do estoque a ser verificado.
     * @return {@code true} se o estoque com o código fornecido já foi cadastrado, {@code false} caso contrário.
     */
    boolean estoqueJaCadastrado(String codigo);
}
