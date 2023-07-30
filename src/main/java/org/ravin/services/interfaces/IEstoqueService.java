/**
 * Interface que define as funcionalidades do serviço de estoque.
 *
 * <p>Esta interface estende a interface {@code IService<Estoque>} para fornecer funcionalidades específicas para gerenciar um estoque.
 * A operação adicional inclui a recuperação de um estoque por seu código.
 *
 * @see IService
 */
package org.ravin.services.interfaces;

import org.ravin.models.Estoque;

import java.util.Optional;

public interface IEstoqueService extends IService<Estoque> {

    /**
     * Recupera um estoque por seu código.
     *
     * @param codigo O código do estoque a ser recuperado.
     * @return Um {@code Optional<Estoque>} que pode conter o estoque se ele foi encontrado, ou estará vazio se o estoque não foi encontrado.
     */
    Optional<Estoque> recuperarPorCodigo(String codigo);
}
