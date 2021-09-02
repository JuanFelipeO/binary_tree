package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.BinaryTree;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BinaryTreeService
{
    private BinaryTree binaryTree = new BinaryTree();

    public ResponseEntity<ResponseBinaryTreeDto> addBoy(Boy boy) throws BinaryTreeException
    {
        binaryTree.addBoy(boy);
        return new ResponseEntity<>(new ResponseBinaryTreeDto(boy,"Boy saved correctly!",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listBoys(int which) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listBoys(which),"Successful!",
                        null),HttpStatus.OK);

    }


    public ResponseEntity<ResponseBinaryTreeDto> count()
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getCount(),"The counter is empty",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> counterEqualNum(Node node, int number) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.counterEqualNum(node,number),"Counter Success",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listEqualNum(int number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listEqualNum(number),"List Success",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listGetLeafs() throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeafs(),"List Success",
                        null),HttpStatus.OK);

    }
}
